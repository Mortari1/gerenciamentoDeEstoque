package br.projeto.gerenciamentodeestoque.modeltable;

import br.projeto.gerenciamentodeestoque.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ProdutoModelTables extends AbstractTableModel {

    private Vector<Vector<Object>> linhas = new Vector<Vector<Object>>();
    private Vector<String> colunas = new Vector<String>();
    private List<Produto> lista;

    public ProdutoModelTables() {
        init();
    }

    public ProdutoModelTables(Vector<String> colunas) {
        this.colunas = colunas;
        
    }

    private void init() {
        colunas.add("Código");
        colunas.add("Item");
        colunas.add("Quantidade");
        colunas.add("Preço de Compra");
        colunas.add("Preço de Venda");
    }

    public int getColumnCount() {
        return colunas.size();
    }

    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int pos) {
        return colunas.get(pos);
    }

    public Object getValueAt(int l, int c) {
        return linhas.get(l).get(c);
    }

    public Produto getAt(int l) {
        return lista.get(l);
    }

    public void removeAt(int l) {
        lista.remove(l);
        renderGrid();
    }

    public void removeAll() {
        lista = new ArrayList<Produto>();

        renderGrid();
    }

    public void add(Produto estado) {
        if (lista == null) {
            lista = new ArrayList<Produto>();
        }

        lista.add(estado);
        renderGrid();
    }

    public void update(Produto produto) {
        for (Produto produtoAux : lista) {
            if (produtoAux.getId_produto().equals(produtoAux.getId_produto())) {
                produtoAux.setItem(produto.getItem());
                break;
            }
        }
        renderGrid();
    }

    public void setGridBusca(List<Produto> lista) {
        this.lista = new ArrayList<Produto>();
        this.lista.addAll(lista);
        renderGrid();
    }

    public void renderGrid() {
        linhas = new Vector<Vector<Object>>();
        for (Produto produto : lista) {

            Vector<Object> linha = new Vector<Object>();
            linha.add(produto.getId_produto());
            linha.add(produto.getItem());
            linha.add(produto.getPrecoCompra());
            linha.add(produto.getPrecoVenda());
            linha.add(produto.getQtd());
            linhas.add(linha);
        }
    }
}