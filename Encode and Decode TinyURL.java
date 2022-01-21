public class Codec {

    HashMap<String,String> longToShortMap = new HashMap<>();
    HashMap<String,String> shortToLongMap = new HashMap<>();
    String baseUrl = "http:tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        if(longToShortMap.containsKey(longUrl)) return baseUrl+longToShortMap.get(longUrl);

        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String hash = "";

        do{
           StringBuilder sb = new StringBuilder();

           for(int i=0;i<6;i++){
               int index =(int) Math.random() * str.length();
               sb.append(str.charAt(i));
           }

            hash= sb.toString();
        }while(longToShortMap.containsKey(hash));

        longToShortMap.put(longUrl,hash);
        shortToLongMap.put(hash,longUrl);
        return baseUrl+hash;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.get(shortUrl.replace(baseUrl,""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
