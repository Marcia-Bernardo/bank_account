import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Agency> agencyLists = new ArrayList<>();
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public void addAgency(Agency agency) {
        agencyLists.add(agency);
    }

    public List<Agency> getAgencyLists() {
        return agencyLists;
    }

    public Agency getAgency(int number) {
        int index = 0;

        for (int i = 0; i < agencyLists.size(); i++) {
            if (agencyLists.get(i).getNumber() == number) {
                index = i;
            }
        }
        return agencyLists.get(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
