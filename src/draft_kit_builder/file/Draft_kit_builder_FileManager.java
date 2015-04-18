/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draft_kit_builder.file;

import draft_kit_builder.data.Draft;
import draft_kit_builder.data.Team;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MatthewLuce
 */
public interface Draft_kit_builder_FileManager {
    public void                 saveTeam(Team TeamToSave) throws IOException;
    public void                 loadTeam(Team TeamToLoad, String coursePath) throws IOException;
    public void                 saveDraft(Draft draft, String filePath) throws IOException;    
    public Draft                loadDraft(String filePath) throws IOException;
    public void                 savePitchers(List<Object> pitchers, String filePath) throws IOException;
    public ArrayList<String>    loadPitchers(String filePath) throws IOException;
    public void                 saveHitters(List<Object> subjects, String filePath) throws IOException;
    public ArrayList<String>    loadHitters(String filePath) throws IOException;
}
