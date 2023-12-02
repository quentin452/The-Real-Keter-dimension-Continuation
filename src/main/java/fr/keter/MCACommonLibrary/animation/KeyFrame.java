package fr.keter.MCACommonLibrary.animation;

import java.util.HashMap;

public class KeyFrame {
   public HashMap modelRenderersRotations = new HashMap();
   public HashMap modelRenderersTranslations = new HashMap();

   public boolean useBoxInRotations(String boxName) {
      return this.modelRenderersRotations.get(boxName) != null;
   }

   public boolean useBoxInTranslations(String boxName) {
      return this.modelRenderersTranslations.get(boxName) != null;
   }
}
