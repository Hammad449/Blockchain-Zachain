import java.util.Date;

public class Block {

    public  String Hash;
    public  String PreviousHash;
    public String Data;
    public long TimeStamp;
    private int nonce;

    public Block(String data, String previousHash){
        this.Data = data;
        this.PreviousHash = previousHash;
        this.TimeStamp = new Date().getTime();
        this.Hash = calculateHash();
    }

    public String calculateHash(){
        String calculatedhash = StringUtil.applySha256(PreviousHash + Long.toString(TimeStamp) + Integer.toString(nonce) + Data);
        return calculatedhash;
    }

    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!Hash.substring(0, difficulty).equals(target)){
            nonce++;
            Hash = calculateHash();
        }
        System.out.println("Block mined: " + Hash);
    }
}
