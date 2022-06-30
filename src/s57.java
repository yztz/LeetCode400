import java.util.HashMap;
import java.util.Map;
/* https://leetcode.cn/problems/encode-and-decode-tinyurl/ */

public class s57 {
    static class Codec {
        Map<String, Long> u2l = new HashMap<>();
        Map<Long, String> l2u = new HashMap<>();
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (u2l.containsKey(longUrl)) return "http://tinyurl.com/" + u2l.get(longUrl);
            long time = System.nanoTime();
            u2l.put(longUrl, time);
            l2u.put(time, longUrl);
            return "http://tinyurl.com/" + time;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String[] pattern = shortUrl.split("/");
            return l2u.getOrDefault(Long.parseLong(pattern[pattern.length - 1]), "");
        }
    }
}
