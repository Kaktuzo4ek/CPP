import java.io.*;
import java.util.*;
import java.util.List;


class Main {
    public static void main(String[] args) {
        DeviceManager.chooseFile();
        DeviceManager.getListOfModels();
        System.out.println();
        DeviceManager.GetCountAndPercentage(DeviceManager.file);
        System.out.println();
        DeviceManager.getUnionList();
        DeviceManager.printAllDevices();
        DeviceManager.calculateSum();
        DeviceManager.printSum();
    }
}
