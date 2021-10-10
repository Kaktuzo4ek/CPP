import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class DeviceManager {
    final static String filePath1 = "D:/3 course 1 sem/CPP/devices.txt";
    final static String filePath2 = "D:/3 course 1 sem/CPP/devices2.txt";
    static String file;

    public static void chooseFile(){
        System.out.println("Open file : 1 ; 2 ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        switch (filename) {
            case "1":
               file = filePath1;
               break;
            case "2":
                file = filePath2;
                break;
            default:
                return;
        }
    }

    public static void getListOfModels(){
        Map<String, List<String>> mapFromFile = GetFromTextFile(file);
        System.out.println("Enter the number of models to output:");
        Scanner scanner = new Scanner(System.in);
        int model_count = scanner.nextInt();
        for (Map.Entry entry : mapFromFile.entrySet()) {
            List<String> value = (List<String>) entry.getValue();
            String models = "[";
            for (int v = 0; v < model_count; v++) {
                if(value.size() == v) break;
                if(v != model_count - 1 && value.size() != 1)
                    models += value.get(v) + ",";
                else models += value.get(v);
            }
            models += "]";
            System.out.println(entry.getKey() + " : "
                    + models);
        }
    }

    public static List<List<String>> getUnionList(){
        List<List<String>> Devices1 = GetAllFromTextFile(filePath1);
        List<List<String>> Devices2 = GetAllFromTextFile(filePath2);
        List<List<String>> AllDevices = Devices1;
        AllDevices.get(0).addAll(Devices2.get(0));
        AllDevices.get(1).addAll(Devices2.get(1));
        AllDevices.get(2).addAll(Devices2.get(2));
        AllDevices.get(3).addAll(Devices2.get(3));
        AllDevices.get(4).addAll(Devices2.get(4));
        List<List<String>> UnmodifiableDevices = Collections.unmodifiableList(AllDevices);
        return UnmodifiableDevices;
    }

    public static Integer calculateSum(){
        Integer sum = getUnionList().get(3).stream().mapToInt(i -> Integer.parseInt(String.valueOf(i))).sum();
        return sum;
    }

    public static void printAllDevices(){
        for(List<String> devices : getUnionList()){
            System.out.println(devices);
        }
    }

    public static void printSum(){
        System.out.println("\nThere are household appliances for this amount: " + calculateSum() + " UAN");
    }

    public static void GetCountAndPercentage(String filename){
        List<String> devices = new ArrayList(getListOfNames(filename));
        for (int i = 0; i < devices.size(); i++) {
            int count = 0;
            for (int j = 0; j < GetDeviceName(filename).size(); j++){
                if(devices.get(i).equals(GetDeviceName(filename).get(j)))
                    count++;
            }
            Double percentage = count/(GetDeviceName(filename).size() * 1.0);
            System.out.println(devices.get(i) + ", Count: " + count + ", Percentage: " + percentage);
        }
    }

    public static Set<String> getListOfNames(String filename){
        Set<String> Names  = new HashSet(GetDeviceName(filename));
        return Names;
    }

    public static List<String> GetDeviceName(String filename){
        List<String> DeviceName = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(filename);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                if (!name.equals("")) DeviceName.add(name);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return DeviceName;
    }
    public static List<String> GetDeviceModel(String filename){
        List<String> DeviceModel = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(filename);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String model = parts[1].trim();
                if (!model.equals("")) DeviceModel.add(model);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return DeviceModel;
    }
    public static List<String> GetDeviceProducer(String filename){
        List<String> DeviceProducer = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(filename);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String producer = parts[2].trim();
                if (!producer.equals("")) DeviceProducer.add(producer);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return DeviceProducer;
    }
    public static List<String> GetDevicePrice(String filename){
        List<String> DevicePrice = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(filename);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String price = parts[3].trim();
                if (!price.equals("")) DevicePrice.add(price);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return DevicePrice;
    }
    public static List<String> GetDevicePower(String filename){
        List<String> DevicePower = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(filename);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String power = parts[4].trim();
                if (!power.equals("")) DevicePower.add(power);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return DevicePower;
    }
    public static Map<String, List<String>> GetFromTextFile(String filename)
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> Name = GetDeviceName(filename);
        List<String> Model = GetDeviceModel(filename);
        List<String> Producer = GetDeviceProducer(filename);
        List<String> Price = GetDevicePrice(filename);
        List<String> Power = GetDevicePower(filename);
        for (int i = 0; i < Producer.size(); i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < Model.size(); j++) {
                if(GetDeviceProducer(filename).get(j).contains(Producer.get(i))){
                    temp.add(Model.get(j));
                }
            }
            map.put(Producer.get(i),temp);
        }
        return map;
    }
    public static List<List<String>> GetAllFromTextFile(String filename)
    {
        List<List<String>> Devices = new ArrayList<>();
        List<String> Name = GetDeviceName(filename);
        List<String> Model = GetDeviceModel(filename);
        List<String> Producer = GetDeviceProducer(filename);
        List<String> Price = GetDevicePrice(filename);
        List<String> Power = GetDevicePower(filename);
        Devices.add(Name);
        Devices.add(Model);
        Devices.add(Producer);
        Devices.add(Price);
        Devices.add(Power);
        return Devices;
    }
}
