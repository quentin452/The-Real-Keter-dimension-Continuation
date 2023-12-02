package animations.New;

import MCACommonLibrary.animation.Channel;
import MCACommonLibrary.animation.KeyFrame;
import MCACommonLibrary.math.Quaternion;
import MCACommonLibrary.math.Vector3f;

public class ChannelStartWalkLinear extends Channel {
   public ChannelStartWalkLinear(String _name, float _fps, int _totalFrames, byte _mode) {
      super(_name, _fps, _totalFrames, _mode);
   }

   protected void initializeAllFrames() {
      KeyFrame frame18 = new KeyFrame();
      frame18.modelRenderersRotations.put("backlegL4", new Quaternion(-0.08715574F, 0.0F, 0.0F, 0.9961947F));
      frame18.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(18, frame18);
      KeyFrame frame21 = new KeyFrame();
      frame21.modelRenderersRotations.put("backlegL4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame21.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(21, frame21);
      KeyFrame frame5 = new KeyFrame();
      frame5.modelRenderersRotations.put("backlegL4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame5.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(5, frame5);
      KeyFrame frame10 = new KeyFrame();
      frame10.modelRenderersRotations.put("backlegL4", new Quaternion(0.17364818F, 0.0F, 0.0F, 0.9848077F));
      frame10.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(10, frame10);
      KeyFrame frame26 = new KeyFrame();
      frame26.modelRenderersRotations.put("backlegL4", new Quaternion(0.17364818F, 0.0F, 0.0F, 0.9848077F));
      frame26.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(26, frame26);
      KeyFrame frame31 = new KeyFrame();
      frame31.modelRenderersRotations.put("backlegL4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame31.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(31, frame31);
      KeyFrame frame15 = new KeyFrame();
      frame15.modelRenderersRotations.put("backlegL4", new Quaternion(0.0F, 0.0F, 0.0F, 1.0F));
      frame15.modelRenderersTranslations.put("backlegL4", new Vector3f(8.0F, -5.0F, 5.0F));
      this.keyFrames.put(15, frame15);
   }
}
