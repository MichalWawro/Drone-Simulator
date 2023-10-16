package com.codecool.ftd.logic;

import com.codecool.ftd.data.Drone;
import com.codecool.ftd.data.Position;

import java.util.List;

public class MovementEngine {

    public void move(Drone drone, String command) {
        switch (command) {
            case "Up" -> drone.setPosition(new Position(drone.getPosition().x(), drone.getPosition().y(), drone.getPosition().z() + 1));
            case "Down" -> {
                if(drone.getPosition().z() > 0) drone.setPosition(new Position(drone.getPosition().x(), drone.getPosition().y(), drone.getPosition().z() - 1));
            }
            default -> {
                if (drone.getPosition().z() > 0) {
                    switch (command) {
                        case "Forward" -> drone.setPosition(
                                new Position(drone.getPosition().x(), drone.getPosition().y() + 1, drone.getPosition().z()));
                        case "Backward" -> drone.setPosition(
                                new Position(drone.getPosition().x(), drone.getPosition().y() - 1, drone.getPosition().z()));
                        case "Right" -> drone.setPosition(
                                new Position(drone.getPosition().x() + 1, drone.getPosition().y(), drone.getPosition().z()));
                        case "Left" -> drone.setPosition(
                                new Position(drone.getPosition().x() - 1, drone.getPosition().y(), drone.getPosition().z()));
                        case "Forward-Left" -> drone.setPosition(
                                new Position(drone.getPosition().x() - 1, drone.getPosition().y() + 1, drone.getPosition().z()));
                        case "Forward-Right" -> drone.setPosition(
                                new Position(drone.getPosition().x() + 1, drone.getPosition().y() + 1, drone.getPosition().z()));
                        case "Backward-Left" -> drone.setPosition(
                                new Position(drone.getPosition().x() - 1, drone.getPosition().y() - 1, drone.getPosition().z()));
                        case "Backward-Right" -> drone.setPosition(
                                new Position(drone.getPosition().x() + 1, drone.getPosition().y() - 1, drone.getPosition().z()));
                    }
                } else {
                    System.out.println("Drone needs to be in the air to move");
                }
            }
        }
    }

    public List<String> getCommands() {
        return List.of(
                "Forward",
                "Backward",
                "Left",
                "Right",
                "\nForward-Left",
                "Forward-Right",
                "Backward-Left",
                "Backward-Right");
    }
}
