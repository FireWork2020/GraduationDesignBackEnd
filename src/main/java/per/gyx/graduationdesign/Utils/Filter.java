package per.gyx.graduationdesign.Utils;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.stereotype.Component;

@Component
public class Filter {

    private static int totalUser = 100;
    private BloomFilter<String> userFilter;
    public boolean containUser(String userName){
        if(userFilter == null){
            return false;
        }
        return userFilter.mightContain(userName);
    }
    public boolean putUser(String userName){
        if(userFilter == null){
            userFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),totalUser);
        }
        return userFilter.put(userName);
    }

}
