import java.util.Arrays;

public class Sandbox {
    public static int getDecodedLength(byte[] rleData) {
        int decodedLength = 0;
        for (int i = 0; i < rleData.length; i += 2) {
            decodedLength += rleData[i];
        }
        return decodedLength;
    }

    public static void main(String[] args) {
        byte[] rleData = {3, 15, 6, 4};
        byte[] decodeRle = new byte[getDecodedLength(rleData)];
        int count = 0;

            //value 1 of decodeRle = value 2 of rleData
        decodeRle[0] = rleData[1];
        //the rest of the values of decodeRle are dependent on the values of rleData[0], rleData[2], and so on
        for (int i = 1; i < decodeRle.length; i++)
        {
            for (int j = 0; j < rleData.length; j += 2)
            {
                count++;
                if (count == 15)
                {
                    break;
                }
                // if rleData [j] > 1, decodeRle[0] must repeat rleData[0] amount of times
                while (rleData[j] <= count)
                {
                    decodeRle[i + 1] = rleData[j];
                }
            }
            count = 0;
        }
        System.out.println(Arrays.toString(decodeRle));
    }
}

