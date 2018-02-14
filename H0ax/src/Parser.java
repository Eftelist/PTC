import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Parser  {

    private static boolean started;
    private static boolean started2;

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject(readFile("C:/Users/Eftelist/Documents/stand.miobject", Charset.defaultCharset()));
        log("interpolate");
        log("length " + "1065");
        double x,y,z,yaws,leftarmx = 0,leftarmy =0,leftarmz= 0,rightarmx =0,rightarmy = 0,rightarmz = 0;
        double x1,y1,z1 = 0;
        HashMap<Integer, Point> pointHashMap = new HashMap<Integer,Point>();

            JSONArray jsonObject = obj.getJSONArray("timelines");
            JSONObject leftarm = jsonObject.getJSONObject(10).getJSONObject("keyframes");
            JSONObject rightarm = jsonObject.getJSONObject(9).getJSONObject("keyframes");
            for(int a = 0; a < jsonObject.length(); a++){
                JSONObject obA = jsonObject.getJSONObject(a);

                if(obA.getString("name").equalsIgnoreCase("head")){
                    JSONObject keyframeOBJ = obA.getJSONObject("keyframes");
                    for(String ab : keyframeOBJ.keySet()){
                        x = get(keyframeOBJ.getJSONObject(ab),"POS_X");
                        y = get(keyframeOBJ.getJSONObject(ab),"POS_Y");
                        z = get(keyframeOBJ.getJSONObject(ab),"POS_Z");
                        x1 = -get(keyframeOBJ.getJSONObject(ab),"ROT_X");
                        y1 = get(keyframeOBJ.getJSONObject(ab),"ROT_Z");
                        z1 = get(keyframeOBJ.getJSONObject(ab),"ROT_Y");
                        if(!started2){
                            started2 = true;
                            if(!leftarm.isNull(String.valueOf((Integer)Integer.valueOf(ab)))){
                                leftarmx = -get(leftarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_X");
                                leftarmy = get(leftarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Z");
                                leftarmz = get(leftarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Y");
                            }
                            if(!rightarm.isNull(String.valueOf((Integer)Integer.valueOf(ab)))){
                                rightarmx = -get(rightarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_X");
                                rightarmy = get(rightarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Z");
                                rightarmz = get(rightarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Y");
                            }

                        } else {
                            if(!leftarm.isNull(String.valueOf((Integer)Integer.valueOf(ab)))){
                                leftarmx = -get(leftarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_X");
                                leftarmy = get(leftarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Y");
                                leftarmz = get(leftarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Z");
                            }
                            if(!rightarm.isNull(String.valueOf((Integer)Integer.valueOf(ab)))){
                                rightarmx = -get(rightarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_X");
                                rightarmy = get(rightarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Y");
                                rightarmz = get(rightarm.getJSONObject(String.valueOf((Integer)Integer.valueOf(ab))), "ROT_Z");
                            }

                        }
                        Point point = new Point(Integer.valueOf(ab),x,y,z,-x1,-y1,z1,0.0, new BodyPart(-leftarmx,-leftarmy - 100,-leftarmz), new BodyPart(-rightarmx,-rightarmy,rightarmz));
                        point.rotateBodyPart(0,-60);
                        point.rotateBodyPart(2,130);
                        point.rotateBodyPart(3,-60);
                        pointHashMap.put(Integer.valueOf(ab),point);

                }
            }

        }
        Map<Integer, Point> map = new TreeMap<Integer, Point>(pointHashMap);
        for(Map.Entry<Integer, Point> i : map.entrySet()){
            log("frame "+i.getValue().getInd());
            for(int b = 0; b < 7; b++){
                log(i.getValue().formatted()[b]);
            }
        }


    }

    private static double get(JSONObject jsonObject1, String X) {
        double x = 0;
        if(!jsonObject1.isNull(X)){
            x = jsonObject1.getDouble(X);
        } else {
            x = 0;
        }
        return x;
    }

    private static void log(String s) {
        System.out.println(s);
    }

}
