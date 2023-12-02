package MCACommonLibrary;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Utils {
   public static FloatBuffer makeFloatBuffer(float[] arr) {
      ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * 4);
      bb.order(ByteOrder.nativeOrder());
      FloatBuffer fb = bb.asFloatBuffer();
      fb.put(arr);
      fb.position(0);
      return fb;
   }

   public static ByteBuffer makeByteBuffer(byte[] arr) {
      ByteBuffer bb = ByteBuffer.allocateDirect(arr.length);
      bb.order(ByteOrder.nativeOrder());
      bb.put(arr);
      bb.position(0);
      return bb;
   }
}
