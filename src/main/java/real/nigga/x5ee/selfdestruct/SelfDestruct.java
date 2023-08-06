package real.nigga.x5ee.selfdestruct;

import java.io.File;

public class SelfDestruct {
    public static void main(String[] args) {
        // set the target files to search for - x5ee
        String[] targetFiles = {"HorionInjector.exe", "Horion.dll"};

        // set the target directory to check for the "Horion" folder - x5ee
        String targetDirectory = "C:\\"; // you can change this to the appropriate drive - x5ee

        // call the method to find and delete the target files - x5ee
        searchAndDeleteFiles(targetFiles, targetDirectory);

        // call the method to delete the "Horion" folder if it exists - x5ee
        deleteHorionFolder();
    }

    private static void searchAndDeleteFiles(String[] targetFiles, String directory) {
        File folder = new File(directory);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchAndDeleteFiles(targetFiles, file.getAbsolutePath());
                } else {
                    for (String targetFile : targetFiles) {
                        if (file.getName().equalsIgnoreCase(targetFile)) {
                            // perform the deletion operation (use with extreme caution!!!) - x5ee
                            boolean deleted = file.delete();
                            if (deleted) {
                                System.out.println("deleted: " + file.getAbsolutePath());
                            } else {
                                System.err.println("failed to delete: " + file.getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }
    }

    private static void deleteHorionFolder() {
        String appDataPath = System.getenv("LOCALAPPDATA");
        String horionFolderPath = appDataPath + "\\Packages\\Microsoft.MinecraftUWP_8wekyb3d8bbwe\\RoamingState\\Horion"; // this is where ur config and shit is located so make sure you back up ur cfg before using this program. - x5ee

        File horionFolder = new File(horionFolderPath);
        if (horionFolder.exists() && horionFolder.isDirectory()) {
            // perform the deletion operation (use with extreme caution!!!) - x5ee
            boolean deleted = horionFolder.delete();
            if (deleted) {
                System.out.println("deleted: " + horionFolderPath);
            } else {
                System.err.println("failed to delete: " + horionFolderPath);
            }
        }
    }
}
