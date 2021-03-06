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
package jfix.zk;

import org.zkoss.zul.Listheader;

public class ObjectListbox<E> extends Listbox implements Refreshable {

	public ObjectListbox(ObjectTableModel<E> model) {
		setMold("paging");
		setWidth("100%");
		setModel(model);
		setItemRenderer(new ObjectTableRenderer<E>(model));
		appendChild(new ObjectTableHeader<E>(model));
		if (model.isSortable()) {
			((Listheader) getListhead().getFirstChild()).sort(true);
		}
	}

	public void refresh() {
		((Refreshable) getModel()).refresh();
	}

	public Object getSelectedValue() {
		if (getSelectedItem() != null && getSelectedItem().getValue() != null) {
			return getSelectedItem().getValue();
		}
		return null;
	}

}
