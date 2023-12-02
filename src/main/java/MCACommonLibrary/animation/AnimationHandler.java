package MCACommonLibrary.animation;

import MCAClientLibrary.MCAModelRenderer;
import MCACommonLibrary.IMCAnimatedEntity;
import MCACommonLibrary.math.Quaternion;
import MCACommonLibrary.math.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;

public abstract class AnimationHandler {
   IMCAnimatedEntity animatedEntity;
   public ArrayList animCurrentChannels = new ArrayList();
   public HashMap animPrevTime = new HashMap();
   public HashMap animCurrentFrame = new HashMap();
   protected HashMap animationEvents = new HashMap();

   public AnimationHandler(IMCAnimatedEntity entity) {
      this.animatedEntity = entity;
   }

   public void activateAnimation(HashMap animChannels, String name, float startingFrame) {
      if (animChannels.get(name) != null) {
         Channel selectedChannel = (Channel)animChannels.get(name);
         int indexToRemove = this.animCurrentChannels.indexOf(selectedChannel);
         if (indexToRemove != -1) {
            this.animCurrentChannels.remove(indexToRemove);
         }

         this.animCurrentChannels.add(selectedChannel);
         this.animPrevTime.put(name, System.nanoTime());
         this.animCurrentFrame.put(name, startingFrame);
         if (this.animationEvents.get(name) == null) {
            this.animationEvents.put(name, new ArrayList());
         }
      } else {
         System.out.println("The animation called " + name + " doesn't exist!");
      }

   }

   public abstract void activateAnimation(String var1, float var2);

   public void stopAnimation(HashMap animChannels, String name) {
      Channel selectedChannel = (Channel)animChannels.get(name);
      if (selectedChannel != null) {
         int indexToRemove = this.animCurrentChannels.indexOf(selectedChannel);
         if (indexToRemove != -1) {
            this.animCurrentChannels.remove(indexToRemove);
            this.animPrevTime.remove(name);
            this.animCurrentFrame.remove(name);
            ((ArrayList)this.animationEvents.get(name)).clear();
         }
      } else {
         System.out.println("The animation called " + name + " doesn't exist!");
      }

   }

   public abstract void stopAnimation(String var1);

   public void animationsUpdate() {
      Iterator it = this.animCurrentChannels.iterator();

      while(it.hasNext()) {
         Channel anim = (Channel)it.next();
         boolean animStatus = updateAnimation(this.animatedEntity, anim, this.animPrevTime, this.animCurrentFrame);
         if (this.animCurrentFrame.get(anim.name) != null) {
            this.fireAnimationEvent(anim, (Float)this.animCurrentFrame.get(anim.name));
         }

         if (!animStatus) {
            it.remove();
            this.animPrevTime.remove(anim.name);
            this.animCurrentFrame.remove(anim.name);
            ((ArrayList)this.animationEvents.get(anim.name)).clear();
         }
      }

   }

   public boolean isAnimationActive(String name) {
      boolean animAlreadyUsed = false;
      Iterator var3 = this.animatedEntity.getAnimationHandler().animCurrentChannels.iterator();

      while(var3.hasNext()) {
         Channel anim = (Channel)var3.next();
         if (anim.name.equals(name)) {
            animAlreadyUsed = true;
            break;
         }
      }

      return animAlreadyUsed;
   }

   private void fireAnimationEvent(Channel anim, Float frame) {
      if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
         this.fireAnimationEventClientSide(anim, frame);
      } else {
         this.fireAnimationEventServerSide(anim, frame);
      }

   }

   @SideOnly(Side.CLIENT)
   public abstract void fireAnimationEventClientSide(Channel var1, Float var2);

   public abstract void fireAnimationEventServerSide(Channel var1, Float var2);

   public static boolean updateAnimation(IMCAnimatedEntity entity, Channel channel, HashMap prevTimeAnim, HashMap prevFrameAnim) {
      long prevTime;
      if (!FMLCommonHandler.instance().getEffectiveSide().isServer() && (!FMLCommonHandler.instance().getEffectiveSide().isClient() || isGamePaused())) {
         prevTime = System.nanoTime();
         prevTimeAnim.put(channel.name, prevTime);
         return true;
      } else {
         prevTime = (Long)prevTimeAnim.get(channel.name);
         float prevFrame = (Float)prevFrameAnim.get(channel.name);
         long currentTime = System.nanoTime();
         double deltaTime = (double)(currentTime - prevTime) / 1.0E9D;
         float numberOfSkippedFrames = (float)(deltaTime * (double)channel.fps);
         float currentFrame = prevFrame + numberOfSkippedFrames;
         if (currentFrame < (float)channel.totalFrames) {
            prevTimeAnim.put(channel.name, currentTime);
            prevFrameAnim.put(channel.name, currentFrame);
            return true;
         } else if (channel.mode == 1) {
            prevTimeAnim.put(channel.name, currentTime);
            prevFrameAnim.put(channel.name, 0.0F);
            return true;
         } else {
            return false;
         }
      }
   }

   @SideOnly(Side.CLIENT)
   private static boolean isGamePaused() {
      Minecraft MC = Minecraft.getMinecraft();
      return MC.isSingleplayer() && MC.currentScreen != null && MC.currentScreen.doesGuiPauseGame() && !MC.getIntegratedServer().getPublic();
   }

   @SideOnly(Side.CLIENT)
   public static void performAnimationInModel(HashMap parts, IMCAnimatedEntity entity) {
      Iterator var2 = parts.entrySet().iterator();

      while(var2.hasNext()) {
         Entry entry = (Entry)var2.next();
         String boxName = (String)entry.getKey();
         MCAModelRenderer box = (MCAModelRenderer)entry.getValue();
         boolean anyRotationApplied = false;
         boolean anyTranslationApplied = false;
         Iterator var8 = entity.getAnimationHandler().animCurrentChannels.iterator();

         while(var8.hasNext()) {
            Channel channel = (Channel)var8.next();
            float currentFrame = (Float)entity.getAnimationHandler().animCurrentFrame.get(channel.name);
            KeyFrame prevRotationKeyFrame = channel.getPreviousRotationKeyFrameForBox(boxName, (Float)entity.getAnimationHandler().animCurrentFrame.get(channel.name));
            int prevRotationKeyFramePosition = prevRotationKeyFrame != null ? channel.getKeyFramePosition(prevRotationKeyFrame) : -1;
            KeyFrame nextRotationKeyFrame = channel.getNextRotationKeyFrameForBox(boxName, (Float)entity.getAnimationHandler().animCurrentFrame.get(channel.name));
            int nextRotationKeyFramePosition = nextRotationKeyFrame != null ? channel.getKeyFramePosition(nextRotationKeyFrame) : 0;
            float SLERPProgress = (currentFrame - (float)prevRotationKeyFramePosition) / (float)(nextRotationKeyFramePosition - prevRotationKeyFramePosition);
            if (SLERPProgress > 1.0F || SLERPProgress < 0.0F) {
               SLERPProgress = 1.0F;
            }

            if (nextRotationKeyFramePosition != 0) {
               Quaternion currentQuat;
               if (prevRotationKeyFramePosition == -1) {
                  currentQuat = new Quaternion();
                  currentQuat.interpolate(((MCAModelRenderer)parts.get(boxName)).defaultRotationAsQuaternion, (Quaternion)nextRotationKeyFrame.modelRenderersRotations.get(boxName), SLERPProgress);
                  box.rotationMatrix.set(currentQuat).transpose();
                  anyRotationApplied = true;
               } else {
                  currentQuat = new Quaternion();
                  currentQuat.interpolate((Quaternion)prevRotationKeyFrame.modelRenderersRotations.get(boxName), (Quaternion)nextRotationKeyFrame.modelRenderersRotations.get(boxName), SLERPProgress);
                  box.rotationMatrix.set(currentQuat).transpose();
                  anyRotationApplied = true;
               }
            }

            KeyFrame prevTranslationKeyFrame = channel.getPreviousTranslationKeyFrameForBox(boxName, (Float)entity.getAnimationHandler().animCurrentFrame.get(channel.name));
            int prevTranslationsKeyFramePosition = prevTranslationKeyFrame != null ? channel.getKeyFramePosition(prevTranslationKeyFrame) : -1;
            KeyFrame nextTranslationKeyFrame = channel.getNextTranslationKeyFrameForBox(boxName, (Float)entity.getAnimationHandler().animCurrentFrame.get(channel.name));
            int nextTranslationsKeyFramePosition = nextTranslationKeyFrame != null ? channel.getKeyFramePosition(nextTranslationKeyFrame) : 0;
            float LERPProgress = (currentFrame - (float)prevTranslationsKeyFramePosition) / (float)(nextTranslationsKeyFramePosition - prevTranslationsKeyFramePosition);
            if (LERPProgress > 1.0F) {
               LERPProgress = 1.0F;
            }

            if (nextTranslationsKeyFramePosition != 0) {
               Vector3f startPosition;
               Vector3f endPosition;
               Vector3f currentPosition;
               if (prevTranslationsKeyFramePosition == -1) {
                  startPosition = ((MCAModelRenderer)parts.get(boxName)).getPositionAsVector();
                  endPosition = (Vector3f)nextTranslationKeyFrame.modelRenderersTranslations.get(boxName);
                  currentPosition = new Vector3f(startPosition);
                  currentPosition.interpolate(endPosition, LERPProgress);
                  box.setRotationPoint(currentPosition.x, currentPosition.y, currentPosition.z);
                  anyTranslationApplied = true;
               } else {
                  startPosition = (Vector3f)prevTranslationKeyFrame.modelRenderersTranslations.get(boxName);
                  endPosition = (Vector3f)nextTranslationKeyFrame.modelRenderersTranslations.get(boxName);
                  currentPosition = new Vector3f(startPosition);
                  currentPosition.interpolate(endPosition, LERPProgress);
                  box.setRotationPoint(currentPosition.x, currentPosition.y, currentPosition.z);
                  anyTranslationApplied = true;
               }
            }
         }

         if (!anyRotationApplied) {
            box.setRotationMatrix(box.defaultRotationMatrix);
         }

         if (!anyTranslationApplied) {
            box.setRotationPoint(box.defaultRotationPointX, box.defaultRotationPointY, box.defaultRotationPointZ);
         }
      }

   }
}
