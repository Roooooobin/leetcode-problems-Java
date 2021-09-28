import java.util.HashSet;

public class Leetcode929 {

    public int numUniqueEmails(String[] emails) {

        HashSet<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String[] localDomain = email.split("@");
            String local = localDomain[0], domain = localDomain[1];
            local = String.join("", local.split("\\."));
            local = local.split("\\+")[0];
            emailSet.add(local + "@" + domain);
        }
        System.out.println(emailSet.toString());
        return emailSet.size();
    }
}
