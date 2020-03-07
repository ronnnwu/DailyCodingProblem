package chapter11;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.function.BiFunction;

public class BloomFilter {
    private List<MessageDigest> hashFunc;
    private boolean[] array;

    public BloomFilter(int CAPACITY) throws NoSuchAlgorithmException {

        hashFunc = List.of(
                MessageDigest.getInstance("MD5"),
                MessageDigest.getInstance("SHA-1"),
                MessageDigest.getInstance("SHA-256"),
                MessageDigest.getInstance("SHA-384"),
                MessageDigest.getInstance("SHA-512")
        );
        array = new boolean[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            array[i] = false;
        }
    }

    private final BiFunction<Integer, MessageDigest, Integer> getHash = new BiFunction<>() {

        @Override
        public Integer apply(Integer integer, MessageDigest md) {
            byte[] digest = md.digest(integer.toString().getBytes(StandardCharsets.UTF_8));
            return (new BigInteger(1, digest).mod(BigInteger.valueOf(array.length))).intValue();
        }
    };

    public void add(int value){
        for (MessageDigest md: hashFunc) {
            Integer idx = getHash.apply(value, md);
            array[idx] = true;
        }
    }

    public boolean check(int value) {
        for (MessageDigest md: hashFunc) {
            Integer idx = getHash.apply(value, md);
            if (array[idx] == false) return false;
        }
        return true;
    }
}
