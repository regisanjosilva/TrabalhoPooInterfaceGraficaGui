package modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {
	
	
	
	
	
	
	//declaraçao variavel 
	private static final String[] colunas =  {
			"ID ", "Nome Completo", "Idade na Matr\u00EDcula", "Email", "Endere\u00E7o", "CEP", "Telefone", "New column", "Curso", "Observa\u00E7\u00F5es", "Ativo"
		};
	
	private ArrayList<Estudante> estudante;
	
	
	
	
	 
		
		
	public ModeloTabela(ArrayList<Estudante> estudante) {
		super();
		this.estudante = estudante;
	}

	@Override
	public int getRowCount() {
		
		return estudante.size() ;
	}

	@Override
	public int getColumnCount() {
		
		return colunas.length;
	}


	public Object getValueAt(int rowIndex, int columnIndex) {
		Estudante estudantes = estudante.get(rowIndex);
		if(columnIndex == 0) {
		   return estudantes.getId();
		}else if (columnIndex == 1) {
			return estudantes.getNomeCompleto();
		}else if (columnIndex == 2) {
			return estudantes.getIdadeNaMatricula();
		}else if (columnIndex == 3) {
			return estudantes.getEmail();
		}else if (columnIndex == 4){
			return estudantes.getCep();
		}else if (columnIndex == 5) {
			return estudantes.getTelefone();
		}else if (columnIndex == 6) {
			return estudantes.getCurso();
			
		}else if (columnIndex == 7) {
			return estudantes.getObservacoes();
			
			
		}else if (columnIndex == 8) {
			return true;
			
		}else {
			return null;
		}
		
		
		
		
	}

	@Override
	public String getColumnName(int column) {
		
		return colunas[column];
	}

	
	}

	


