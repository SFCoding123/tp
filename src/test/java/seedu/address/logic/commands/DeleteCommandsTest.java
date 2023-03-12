package seedu.address.logic.commands;

//import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;



public class DeleteCommandsTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());


    @Test
    public void execute_validIndexsUnfilteredList_success() {

        Person personToDelete1 = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person personToDelete2 = model.getFilteredPersonList().get(INDEX_SECOND_PERSON.getZeroBased());
        ArrayList<Index> temp = new ArrayList<>();
        temp.add(INDEX_SECOND_PERSON);
        temp.add(INDEX_FIRST_PERSON);
        DeleteCommands deleteCommands = new DeleteCommands(temp);


        String people = personToDelete1 + " " + personToDelete2 + " ";
        String expectedMessage = String.format(DeleteCommands.MESSAGE_DELETE_PERSON_SUCCESS, people);


        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deletePerson(personToDelete1);
        expectedModel.deletePerson(personToDelete2);

        /*
        assertCommandSuccess(deleteCommands, model, expectedMessage, expectedModel);
        System.out.println(expectedMessage);
        System.out.println(expectedModel);

         */

    }
}
