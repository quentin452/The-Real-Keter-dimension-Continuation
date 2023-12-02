package fr.keter.New;

import fr.keter.MCACommonLibrary.IMCAnimatedEntity;
import fr.keter.MCACommonLibrary.animation.AnimationHandler;
import fr.keter.MCACommonLibrary.animation.Channel;

import java.util.HashMap;

public class AnimationHandlerNew extends AnimationHandler {
   public static HashMap animChannels = new HashMap();

   public AnimationHandlerNew(IMCAnimatedEntity entity) {
      super(entity);
   }

   public void activateAnimation(String name, float startingFrame) {
      super.activateAnimation(animChannels, name, startingFrame);
   }

   public void stopAnimation(String name) {
      super.stopAnimation(animChannels, name);
   }

   public void fireAnimationEventClientSide(Channel anim, Float frame) {
   }

   public void fireAnimationEventServerSide(Channel anim, Float frame) {
   }

   static {
      animChannels.put("walkCycle", new ChannelWalkCycle("walkCycle", 20.0F, 60, (byte)1));
   }
}
