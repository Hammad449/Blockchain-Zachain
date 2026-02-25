import java.util.Date;

public class Block {

    public  String Hash;
    public  String PreviousHash;
    public String Data;
    public long TimeStamp;

    public Block(String data, String previousHash){
        this.Data = data;
        this.PreviousHash = previousHash;
        this.TimeStamp = new Date().getTime();
        this.Hash = calculateHash();
    }

    public String calculateHash(){
        String calculatedhash = StringUtil.applySha256(PreviousHash + Long.toString(TimeStamp) + Data);
        return calculatedhash;
    }
}
