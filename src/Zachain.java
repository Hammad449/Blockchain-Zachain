import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Zachain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        Block genesisBlock = new Block("First block in the chain - Genesis block", "0");
        System.out.println("Hash for Block 1 : " + genesisBlock.Hash);

        Block block2 = new Block("Second block in the chain", genesisBlock.Hash);
        System.out.println("Hash for Block 2 : " + block2.Hash);

        Block block3 = new Block("Third block in the chain", block2.Hash);
        System.out.println("Hash for Block 3 : " + block3.Hash);

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}
