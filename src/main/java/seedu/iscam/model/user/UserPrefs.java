package seedu.iscam.model.user;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.iscam.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path clientBookFilePath = Paths.get("data", "clientbook.json");
    private Path meetingBookFilePath = Paths.get("data", "meetingbook.json");

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {
    }

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setClientBookFilePath(newUserPrefs.getClientBookFilePath());
        setMeetingBookFilePath(newUserPrefs.getMeetingBookFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getClientBookFilePath() {
        return clientBookFilePath;
    }

    public void setClientBookFilePath(Path clientBookFilePath) {
        requireNonNull(clientBookFilePath);
        this.clientBookFilePath = clientBookFilePath;
    }

    public Path getMeetingBookFilePath() {
        return meetingBookFilePath;
    }

    public void setMeetingBookFilePath(Path meetingBookFilePath) {
        requireNonNull(meetingBookFilePath);
        this.meetingBookFilePath = meetingBookFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && clientBookFilePath.equals(o.clientBookFilePath)
                && meetingBookFilePath.equals(o.meetingBookFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, clientBookFilePath, meetingBookFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal client data file location : " + clientBookFilePath);
        sb.append("\nLocal meeting data file location : " + meetingBookFilePath);
        return sb.toString();
    }

}
