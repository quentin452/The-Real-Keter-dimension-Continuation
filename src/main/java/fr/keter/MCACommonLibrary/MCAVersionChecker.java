package fr.keter.MCACommonLibrary;

public class MCAVersionChecker {
   public static final int VersionID = 1;

   public static void checkForLibraryVersion(Class modelClass, int modelVersion) {
      if (modelVersion > 1) {
         System.out.println("MCA WARNING: " + modelClass.getName() + " needs a newer version of the library (" + modelVersion + "). Things could go wrong!");
      }

   }
}
