import java.lang.Integer ;

public class SeqReceive {
    private byte[] temp;
    public static int seqno = 0;

    public SeqReceive(byte[] temp) {
        this.temp = temp;
    }

    public boolean getSeq() {
        Byte num = new Byte(temp[temp.length - 1]);
        int n = num.intValue();
        if(seqno>126) seqno = 0;
        if (n >= seqno) { //Compares the sequence number of the packet with the last played sequence number.
            seqno = n;
            return true;
        }
        return false;
    }
}