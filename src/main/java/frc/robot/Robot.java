/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.lightning.LightningContainer;
import frc.lightning.LightningRobot;

import java.nio.file.Files;
import java.nio.file.Paths;

import frc.robot.containers.*;

public class Robot extends LightningRobot {

    //Put all of the supported robots in a list because it looks nice 
    public static final String[] ROBOT_NAMES = {
        "sparkplug", //2009
        "eddie", //2012
        "orion", //2013
        "neo", //2014
        "flash", //2015
        "sirius", //2016
        "valkyrie", //2017
        "glitch", //2018
        "gemini", "quasar", //2019
        "greg", "illusion", //2020
        "howitzer" //2021
    };

    public Robot() {
        super(getRobot());
    }

    private static LightningContainer getRobot() {
        //Still have to use a switch statment because they are individual containers
        switch (getRobotName()) {
            /*
            case "sparkplug":
                return new SparkPlugContainer();*/
            case "eddie":
                return new EddieContainer();
            /*case "orion":
                return new OrionContainer();
            case "neo":
                return new NeoContainer();
            case "flash":
                return new FlashContainer();
            case "sirius":
                return new SiriusContainer();
            case "valkyrie":
                return new ValkrieContainer();*/
            case "glitch":
                return new GlitchContainer();
            /*case "gemini":
                return new GeminiContainer();
            case "quasar":
                return new QuasarContainer();
            case "greg":
                return new GregContainer();
            case "illusion":
                return new IllusionContainer();
            case "howitzer":
                return new HowitzerContainer();*/
            default:
                return null;
        }
    }

    public static String getRobotName() {
        for (String i : ROBOT_NAMES) {
            if (Files.exists(Paths.get("/home/lvuser/" + i))) {
                return i;
            }
        }
        return "";
    }
}
