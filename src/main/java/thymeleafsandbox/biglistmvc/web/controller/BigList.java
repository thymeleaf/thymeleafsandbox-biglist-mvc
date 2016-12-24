/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package thymeleafsandbox.biglistmvc.web.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import thymeleafsandbox.biglistmvc.business.PlaylistEntry;
import thymeleafsandbox.biglistmvc.business.repository.PlaylistEntryRepository;


@Controller
public class BigList {


    @Autowired
    private PlaylistEntryRepository playlistEntryRepository;



    public BigList() {
        super();
    }



    @RequestMapping("/biglist.thymeleaf")
    public String bigListThymeleaf(final Model model) {

        final Iterator<PlaylistEntry> playlistEntries = this.playlistEntryRepository.findLargeCollectionPlaylistEntries();
        model.addAttribute("dataSource", playlistEntries);

        return "thymeleaf/biglist";

    }


    @RequestMapping("/biglist.freemarker")
    public String bigListFreeMarker(final Model model) {

        final Iterator<PlaylistEntry> playlistEntries = this.playlistEntryRepository.findLargeCollectionPlaylistEntries();
        model.addAttribute("dataSource", playlistEntries);

        return "freemarker/biglist";

    }

}