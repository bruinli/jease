/*
    Copyright (C) 2015 maik.jablonski@jease.org

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jease.cms.web.content.editor;

import jease.cms.domain.Link;
import jease.cms.web.component.Linkfield;
import jfix.util.I18N;

import org.apache.commons.lang3.StringUtils;

public class LinkEditor extends ContentEditor<Link> {

	Linkfield link = new Linkfield();

	public LinkEditor() {
	}

	public void init() {
		add(I18N.get("Url"), link);
	}

	public void load() {
		link.setValue(getNode().getUrl());
	}

	public void save() {
		getNode().setUrl(link.getValue());
	}

	public void validate() {
		validate(StringUtils.isEmpty(link.getValue()),
				I18N.get("Url_is_required"));
	}
}
