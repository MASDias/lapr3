package lapr.project.model;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Objects;

public class AlgorithmResults {

    private final Project project;
    private final LinkedList<Junction> junctionpath;
    private final LinkedList<Section> sectionpath;
    private final Vehicle vehicle;
    private double cost;
    private double distance;
    private final double travelTime;
    private final double energy;
    private final double vehicleLoad;
    private final String algorithmType;
    private final double fuelGrams;

    public AlgorithmResults(Project project, LinkedList<Junction> junctionPath, LinkedList<Section> fastestPath, Vehicle vehicle, double[] results, String algorithmType) {
        this.project = project;
        this.junctionpath = junctionPath;
        this.sectionpath = fastestPath;
        this.vehicle = vehicle;
        this.travelTime = results[0];
        this.energy = results[1];
        this.vehicleLoad = vehicle.getCurrentLoad();
        this.algorithmType = algorithmType;
        if (results.length > 2) {
            this.fuelGrams = results[2];
        } else {
            fuelGrams = -1;
        }
    }

    public void calculate() {
        double tempCost = 0;
        double tollValue;
        double tempDistance = 0;
        for (Section section : sectionpath) {
            tempDistance += section.getSectionLength();
            String sectionID = section.getRoadID();
            Road rd = project.getRoadByRoadID(sectionID);
            if ("toll highway".equalsIgnoreCase(rd.getTypology())) {
                if (rd.getTollValue(vehicle.getVehicleClass()) > 0) {
                    tollValue = rd.getTollValue(vehicle.getVehicleClass());
                    tempCost += tollValue * section.getSectionLength();
                }

            }
            if ("gantry toll highway".equalsIgnoreCase(rd.getTypology())) {
                if (section.getTollValue(vehicle.getVehicleClass()) > 0) {
                    tempCost += section.getTollValue(vehicle.getVehicleClass());
                }
            }
        }
        cost = tempCost;
        distance = tempDistance;

    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Project getProject() {
        return project;
    }

    public double getEnergy() {
        return energy;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public double getCost() {
        return cost;
    }

    public double getDistance() {
        return distance;
    }

    public LinkedList<Section> getSectionPath() {
        return sectionpath;
    }

    public LinkedList<Junction> getJunctionPath() {
        return junctionpath;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getVehicleLoad() {
        return vehicleLoad;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public double getFuelGrams() {
        return fuelGrams;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlgorithmResults other = (AlgorithmResults) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(other.distance)) {
            return false;
        }
        if (Double.doubleToLongBits(this.travelTime) != Double.doubleToLongBits(other.travelTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.energy) != Double.doubleToLongBits(other.energy)) {
            return false;
        }
        if (Double.doubleToLongBits(this.vehicleLoad) != Double.doubleToLongBits(other.vehicleLoad)) {
            return false;
        }
        if (!Objects.equals(this.algorithmType, other.algorithmType)) {
            return false;
        }
        if (!Objects.equals(this.project, other.project)) {
            return false;
        }
        if (!Objects.equals(this.junctionpath, other.junctionpath)) {
            return false;
        }
        if (!Objects.equals(this.sectionpath, other.sectionpath)) {
            return false;
        }
        return Objects.equals(this.vehicle, other.vehicle);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Project: ").append(project.getName()).append("\n");
        sb.append("\nAlgorithm: ").append(algorithmType);
        sb.append("\n");
        sb.append("Vehicle: ").append(vehicle.getName()).append("\n");
        sb.append("Vehicle total weight: ").append(vehicle.getTotalWeight()).append((" kg\n"));
        sb.append("\nPath:\n");
        for (Section s : sectionpath) {
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\nDistance:").append(distance).append(" km");
        sb.append("\nTravel time:").append(UnitConversion.convertSecondstoHoursMinSec(travelTime)).append(" h");
        sb.append("\nCost:").append(new DecimalFormat("#.##").format(cost)).append(" €");
        sb.append("\nEnergy:").append(String.format("%.2f", UnitConversion.convertJoulesToMegaJoules(energy))).append(" MJ");

        if (vehicle instanceof VehicleCombustion) {
            if (fuelGrams > 0) {
                double liters = UnitConversion.convertGramsOfFuelToLiters(vehicle.getFuel(), fuelGrams);
                double km100 = UnitConversion.convertLitersToLiterPer100KM(liters, distance);
                sb.append(("\nFuel used:")).append(new DecimalFormat("#.##").format(liters)).append((" liters"));
                sb.append("\nConsumption:").append(new DecimalFormat("#.##").format(km100)).append(" liters/100km");
            }
        } else {
            if (vehicle instanceof VehicleElectric) {
                double kwh = UnitConversion.convertJoulesToKilowattHour(energy);
                sb.append("\nComsumption:").append(new DecimalFormat("#.##").format(kwh)).append(" kW/h");

            }
        }

        return sb.toString();
    }

    /**
     * Returns the textual description of the object in html format.
     *
     * @return Textual description of the object.
     */
    public String toStringHTML() {

        StringBuilder sb = new StringBuilder();

        StringBuilder path = new StringBuilder();
        int i = 1;
        for (Section section : sectionpath) {
            path.append(("Section " + i + ":")).append(section.toStringHTML() + "\n");
            i++;
        }

        if (vehicle instanceof VehicleCombustion) {
            double liters = UnitConversion.convertGramsOfFuelToLiters(vehicle.getFuel(), fuelGrams);
            double km100 = UnitConversion.convertLitersToLiterPer100KM(liters, distance);

            sb.append("<table>\n");
            sb.append("\t<tr><th>Algorithm</th><th>Vehicle</th><th>Travel Time</th><th>Distance</th><th>Consumed Energy</th><th>Cost</th><th>Fuel Used</th><th>Consumption</th></tr>\n");

            sb.append("<tr>"
                    + "<td>").append(this.algorithmType).append("</td>"
                    + "<td>").append(this.vehicle.getName()).append("</td>"
                    + "<td>").append(UnitConversion.convertSecondstoHoursMinSec(this.travelTime)).append(" h</td>"
                    + "<td>").append(new DecimalFormat("#.##").format(this.distance)).append(" km</td>"
                    + "<td>").append(String.format("%.2f", UnitConversion.convertJoulesToMegaJoules(energy))).append(" MJ</td>"
                    + "<td>").append(new DecimalFormat("#.##").format(this.cost)).append(" €</td>"
                    + "<td>").append(new DecimalFormat("#.##").format(liters)).append(" liters"
                    + "<td>").append(new DecimalFormat("#.##").format(km100)).append(" liters/100km</td>");
            sb.append("</tr>\n");
            sb.append("</table>\n");
            sb.append("<h2> </h2>");
            sb.append("<table>\n");
            sb.append("\t<tr><th>Path</th></tr>\n");
            sb.append("<tr>"
                    + "<td>").append(path).append("</td>");
            sb.append("</tr>\n");
            sb.append("</table>");
        }

        if (vehicle instanceof VehicleElectric) {
            double kwh = UnitConversion.convertJoulesToKilowattHour(energy);
            sb.append("<table>\n");
            sb.append("\t<tr><th>Algorithm</th><th>Vehicle</th><th>Travel Time</th><th>Distance</th><th>Consumed Energy</th><th>Cost</th><th>Consumption</th></tr>\n");

            sb.append("<tr>"
                    + "<td>").append(this.algorithmType).append("</td>"
                    + "<td>").append(this.vehicle.getName()).append("</td>"
                    + "<td>").append(UnitConversion.convertSecondstoHoursMinSec(this.travelTime)).append(" h</td>"
                    + "<td>").append(new DecimalFormat("#.##").format(this.distance)).append(" km</td>"
                    + "<td>").append(String.format("%.2f", UnitConversion.convertJoulesToMegaJoules(energy))).append(" MJ</td>"
                    + "<td>").append(new DecimalFormat("#.##").format(this.cost)).append(" €</td>"
                    + "<td>").append(new DecimalFormat("#.##").format(kwh)).append(" kw/h</td>");
            sb.append("</tr>\n");
            sb.append("</table>\n");
            sb.append("<h2> </h2>");
            sb.append("<table>\n");
            sb.append("\t<tr><th>Path</th></tr>\n");
            sb.append("<tr>"
                    + "<td>").append(path).append("</td>");
            sb.append("</tr>\n");
            sb.append("</table>");

        }

        return sb.toString();
    }

}
