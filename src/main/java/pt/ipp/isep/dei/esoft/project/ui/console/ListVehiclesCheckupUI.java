package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListVehiclesCheckupController;
import pt.ipp.isep.dei.esoft.project.domain.PlateCertification;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.VehicleCheckUp;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListVehiclesCheckupUI implements Runnable{
    ListVehiclesCheckupController controller;

    /**
     * Instantiates the controller.
     */
    public ListVehiclesCheckupUI(){
        controller = new ListVehiclesCheckupController();
    }

    private String convertStrArrToFormattedLine(String[] strArr, String startingStr){
        StringBuilder str = new StringBuilder(startingStr);
        for (String s : strArr) {
            str.append(String.format("%15s", s));
        }
        return str.toString();
    }
    @Override
    public void run() {
        Map<Vehicle, VehicleCheckUp[]> vehNeedingIt = controller.getVehiclesNeedingCheckup();

        List<String> data = new ArrayList<>();
        for (Map.Entry<Vehicle, VehicleCheckUp[]> entry :
                vehNeedingIt.entrySet()) {
            Vehicle veh = entry.getKey();
            VehicleCheckUp[] checkUps = entry.getValue();
            PlateCertification vehPlateCert = veh.getPlateCertification();
            String[] entryToStrArr = new String[]{vehPlateCert.getPlate(), vehPlateCert.getBrand(), vehPlateCert.getModel(), String.valueOf(veh.getCurrentKm()), String.valueOf(veh.getMaintenance()), String.valueOf(checkUps[0].getKms()), String.valueOf(checkUps[1].getKms())};

            data.add(convertStrArrToFormattedLine(entryToStrArr, ""));
        }
        String[] header = new String[]{"Plate","Brand","Model","Curr.Kms", "Freq", "Last", "Next"};
        Utils.showList(data, convertStrArrToFormattedLine(header, "      "));
    }
}
