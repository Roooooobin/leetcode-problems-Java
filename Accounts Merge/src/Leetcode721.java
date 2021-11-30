import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode721 {

    // WA
    //    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    //
    //        HashMap<String, Integer> name2Count = new HashMap<>();
    //        HashMap<String, String> account2Name = new HashMap<>();
    //        for (List<String> account : accounts) {
    //            String name = account.get(0);
    //            int countName = name2Count.getOrDefault(name, 0);
    //            name2Count.put(name, countName + 1);
    //            String nameId = name + "|" + countName;
    //            for (int i = 1; i < account.size(); i++) {
    //                if (account2Name.containsKey(account.get(i))) {
    //                    nameId = account2Name.get(account.get(i));
    //                    break;
    //                }
    //            }
    //            for (int i = 1; i < account.size(); i++) {
    //                account2Name.put(account.get(i), nameId);
    //            }
    //        }
    //        HashMap<String, List<String>> name2Accounts = new HashMap<>();
    //        for (String account : account2Name.keySet()) {
    //            String name = account2Name.get(account);
    //            name2Accounts.putIfAbsent(name, new ArrayList<>());
    //            name2Accounts.get(name).add(account);
    //        }
    //        List<List<String>> res = new ArrayList<>();
    //        for (String nameWithID : name2Accounts.keySet()) {
    //            List<String> accountList = name2Accounts.get(nameWithID);
    //            accountList.sort(String::compareTo);
    //            String[] ss = nameWithID.split("\\|");
    //            String name = ss[0];
    //            accountList.add(0, name);
    //            res.add(accountList);
    //        }
    //        return res;
    //    }

    class Solution {

        private HashMap<String, String> parents = new HashMap<>();
        private HashMap<String, Integer> account2NameIdx = new HashMap<>();

        public List<List<String>> accountsMerge(List<List<String>> accounts) {

            // init parents, account2NameIdx
            for (int i = 0; i < accounts.size(); i++) {
                List<String> account = accounts.get(i);
                for (int j = 1; j < account.size(); j++) {
                    String accountName = account.get(j);
                    parents.put(accountName, accountName);
                    account2NameIdx.put(accountName, i);
                }
            }
            for (List<String> account : accounts) {
                for (int j = 1; j < account.size(); j++) {
                    String accountName = account.get(j);
                    combine(accountName, account.get(1));
                }
            }
            //            System.out.println(parents.toString());
            HashMap<Integer, List<String>> nameIdx2Accounts = new HashMap<>();
            for (String accountName : parents.keySet()) {
                int nameIdx = account2NameIdx.get(findParent(accountName));
                nameIdx2Accounts.putIfAbsent(nameIdx, new ArrayList<>());
                nameIdx2Accounts.get(nameIdx).add(accountName);
            }
            List<List<String>> res = new ArrayList<>();
            for (int nameIdx : nameIdx2Accounts.keySet()) {
                List<String> accountList = nameIdx2Accounts.get(nameIdx);
                accountList.sort(String::compareTo);
                String name = accounts.get(nameIdx).get(0);
                accountList.add(0, name);
                res.add(accountList);
            }
            return res;
        }

        public String findParent(String s) {

            String r = s;
            while (!parents.get(r).equals(r)) {
                r = parents.get(r);
            }
            while (!s.equals(r)) {
                String p = parents.get(s);
                parents.put(s, r);
                s = p;
            }
            return r;
        }

        public void combine(String x, String y) {

            x = findParent(x);
            y = findParent(y);
            if (!x.equals(y)) {
                parents.put(x, y);
            }
        }
    }
}
