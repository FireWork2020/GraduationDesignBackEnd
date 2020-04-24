package per.gyx.graduationdesign.Utils;

import per.gyx.graduationdesign.entity.Task;

import java.io.*;

public class SerializeObject{

    private static class BAOSHolder{
        private static final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    }
    private static class OOSHolder{
        private volatile static ObjectOutputStream oos;
        public static ObjectOutputStream getOos() throws IOException {
            if(oos == null){
                synchronized (ObjectOutputStream.class){
                    if(oos == null){
                        oos = new ObjectOutputStream(BAOSHolder.baos);
                    }
                }
            }
            return oos;
        }
    }
    public static byte[] serialize(Task task) throws IOException {
        try{
            ByteArrayOutputStream baos = BAOSHolder.baos;
            ObjectOutputStream oos = OOSHolder.getOos();
            oos.writeObject(task);
            byte[] b = baos.toByteArray();
            baos.close();
            oos.close();
            return b;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Task deSerialize(byte[] b){
        ByteArrayInputStream bais = null;
        try{
            bais = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bais);
            bais.close();
            ois.close();
            Task task = (Task)ois.readObject();
            System.out.println("deSerialize task:"+task.getCollectcode());
            return task;
        }catch (IOException | ClassNotFoundException e1){
            e1.printStackTrace();
        }
        return null;

    }
}
