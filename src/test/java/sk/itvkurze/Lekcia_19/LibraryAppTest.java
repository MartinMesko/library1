package sk.itvkurze.Lekcia_19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryAppTest extends LibraryAppHelper{


    private MembersPage membersPage;
    private Member member1, member2;

    @BeforeEach
    public void setUp() {
        membersPage = new MembersPage();
        member1 = new Member("Fero", "Skovajsa", "01/01/2000", 1);
        member2 = new Member("Juraj", "Jánošík", "02/02/2002", 2);
        MembersPage.members.clear();
    }

    // Testuje, či po pridaní člena je tento člen skutočne v zozname.
    @Test
    public void whenMemberIsAddedThenMemberExistsInList() {
        membersPage.saveMember(member1);
        assertTrue(MembersPage.members.contains(member1));
    }

    // Testuje, či po odstránení člena zo zoznamu, tento člen už v zozname nie je.
    @Test
    public void whenMemberIsRemovedThenMemberDoesNotExistInList() {
        MembersPage.members.add(member1);
        MembersPage.members.add(member2);

        MembersPage.members.remove(member1);

        assertFalse(MembersPage.members.contains(member1));
        assertTrue(MembersPage.members.contains(member2));
    }


    // test ci metoda saveMember() realne ulozi noveho member do databazi (txt suboru)
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderAddMember.class)
    void whenMemberIsAddedThenMemberExistsInFile(Member member, String searchedText){
        boolean actual = MembersPage.saveMember(member);
        boolean expected = searchInFile(MembersPage.memberFilePath, searchedText);
        assertEquals(expected, actual);
    }

    // test TREBA PREROBIT!!! momentalne testuje len existenciu pola members.
    // Metody add() a remove() su sucastou kniznice java.util.
    // To iste plati Mato aj pre tvoju povodnu verziu.
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderRemoveMember.class)
    public void whenMemberIsRemovedThenMemberDoesNotExistInList(Member member, boolean expected) {
        MembersPage.members.add(member);
        if (expected){
            MembersPage.members.remove(member);
        }
        boolean actual = MembersPage.members.contains(member);
        assertEquals(!expected, actual);
    }
}
