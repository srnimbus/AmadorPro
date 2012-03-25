package br.com.srnimbus.amadorpro.mvc.dm;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.srnimbus.amadorpro.to.AbstractTO;

public class AbstractDataModel extends ListDataModel<AbstractTO> implements SelectableDataModel<AbstractTO> {

	@SuppressWarnings("unused")
	private AbstractDataModel() {
	}

	public AbstractDataModel(List<AbstractTO> listaTO) {
		super(listaTO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public AbstractTO getRowData(String id) {

		List<AbstractTO> listaTO = (List<AbstractTO>) getWrappedData();
		for (AbstractTO to : listaTO) {
			if (to.getId() == (Integer.parseInt(id))) {
				return to;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(AbstractTO to) {
		return Integer.toString(to.getId());
	}

}
