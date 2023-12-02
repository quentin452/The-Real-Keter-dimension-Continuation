package animations.New;

import MCACommonLibrary.animation.Channel;
import MCACommonLibrary.animation.KeyFrame;
import MCACommonLibrary.math.Quaternion;
import MCACommonLibrary.math.Vector3f;

public class ChannelWalkCycle extends Channel {
   public ChannelWalkCycle(String _name, float _fps, int _totalFrames, byte _mode) {
      super(_name, _fps, _totalFrames, _mode);
   }

   protected void initializeAllFrames() {
      KeyFrame frame0 = new KeyFrame();
      frame0.modelRenderersRotations.put("frontlegL1", new Quaternion(0.3007058F, 0.0F, 0.0F, 0.95371693F));
      frame0.modelRenderersRotations.put("fronlegR3", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
      frame0.modelRenderersRotations.put("backlegR4", new Quaternion(0.17364818F, 0.0F, 0.0F, 0.9848077F));
      frame0.modelRenderersRotations.put("backlegL4", new Quaternion(-0.08715574F, 0.0F, 0.0F, 0.9961947F));
      frame0.modelRenderersTranslations.put("frontlegL1", new Vector3f(9.0F, -3.5F, 15.8F));
      frame0.modelRenderersTranslations.put("fronlegR3", new Vector3f(-1.0F, -3.5F, 15.8F));
      frame0.modelRenderersTranslations.put("backlegR4", new Vector3f(0.0F, -5.0F, 5.0F));
      frame0.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(0, frame0);
      KeyFrame frame17 = new KeyFrame();
      frame17.modelRenderersRotations.put("frontlegL1", new Quaternion(0.3007058F, 0.0F, 0.0F, 0.95371693F));
      frame17.modelRenderersRotations.put("fronlegR3", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
      frame17.modelRenderersRotations.put("backlegR4", new Quaternion(0.17364818F, 0.0F, 0.0F, 0.9848077F));
      frame17.modelRenderersRotations.put("backlegL4", new Quaternion(-0.08715574F, 0.0F, 0.0F, 0.9961947F));
      frame17.modelRenderersTranslations.put("frontlegL1", new Vector3f(9.0F, -3.5F, 15.8F));
      frame17.modelRenderersTranslations.put("fronlegR3", new Vector3f(-1.0F, -3.5F, 15.8F));
      frame17.modelRenderersTranslations.put("backlegR4", new Vector3f(0.0F, -5.0F, 5.0F));
      frame17.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(17, frame17);
      KeyFrame frame3 = new KeyFrame();
      frame3.modelRenderersRotations.put("frontlegL1", new Quaternion(0.21643962F, 0.0F, 0.0F, 0.976296F));
      frame3.modelRenderersRotations.put("fronlegR3", new Quaternion(0.4617486F, 0.0F, 0.0F, 0.8870108F));
      frame3.modelRenderersRotations.put("backlegL4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame3.modelRenderersTranslations.put("frontlegL1", new Vector3f(9.0F, -3.5F, 15.8F));
      frame3.modelRenderersTranslations.put("fronlegR3", new Vector3f(-1.0F, -3.5F, 15.8F));
      frame3.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(3, frame3);
      KeyFrame frame5 = new KeyFrame();
      frame5.modelRenderersRotations.put("backlegR4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame5.modelRenderersTranslations.put("backlegR4", new Vector3f(0.0F, -5.0F, 5.0F));
      this.keyFrames.put(5, frame5);
      KeyFrame frame6 = new KeyFrame();
      frame6.modelRenderersRotations.put("fronlegR3", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
      frame6.modelRenderersTranslations.put("fronlegR3", new Vector3f(-1.0F, -3.5F, 15.8F));
      this.keyFrames.put(6, frame6);
      KeyFrame frame8 = new KeyFrame();
      frame8.modelRenderersRotations.put("frontlegL1", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
      frame8.modelRenderersRotations.put("backlegR4", new Quaternion(-0.08715574F, 0.0F, 0.0F, 0.9961947F));
      frame8.modelRenderersRotations.put("backlegL4", new Quaternion(0.17364818F, 0.0F, 0.0F, 0.9848077F));
      frame8.modelRenderersTranslations.put("frontlegL1", new Vector3f(9.0F, -3.5F, 15.8F));
      frame8.modelRenderersTranslations.put("backlegR4", new Vector3f(0.0F, -5.0F, 5.0F));
      frame8.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(8, frame8);
      KeyFrame frame11 = new KeyFrame();
      frame11.modelRenderersRotations.put("frontlegL1", new Quaternion(0.4617486F, 0.0F, 0.0F, 0.8870108F));
      frame11.modelRenderersRotations.put("fronlegR3", new Quaternion(0.21643962F, 0.0F, 0.0F, 0.976296F));
      frame11.modelRenderersRotations.put("backlegR4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame11.modelRenderersTranslations.put("frontlegL1", new Vector3f(9.0F, -3.5F, 15.8F));
      frame11.modelRenderersTranslations.put("fronlegR3", new Vector3f(-1.0F, -3.5F, 15.8F));
      frame11.modelRenderersTranslations.put("backlegR4", new Vector3f(0.0F, -5.0F, 5.0F));
      this.keyFrames.put(11, frame11);
      KeyFrame frame13 = new KeyFrame();
      frame13.modelRenderersRotations.put("backlegL4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame13.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(13, frame13);
      KeyFrame frame14 = new KeyFrame();
      frame14.modelRenderersRotations.put("frontlegL1", new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F));
      frame14.modelRenderersTranslations.put("frontlegL1", new Vector3f(9.0F, -3.5F, 15.8F));
      this.keyFrames.put(14, frame14);
   }
}
