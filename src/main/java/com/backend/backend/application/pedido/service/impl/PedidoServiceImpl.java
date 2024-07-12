package com.backend.backend.application.pedido.service.impl;

import com.backend.backend.application.pedido.dto.PedidoDTO;
import com.backend.backend.application.pedido.mapper.PedidoMapper;
import com.backend.backend.application.pedido.service.IPedidoService;
import com.backend.backend.domain.bodega.Bodega;
import com.backend.backend.domain.bodega.BodegaRepository;
import com.backend.backend.domain.bodega.TipoBodega;
import com.backend.backend.domain.cliente.Cliente;
import com.backend.backend.domain.cliente.ClienteRepository;
import com.backend.backend.domain.contans.MessageApplication;
import com.backend.backend.domain.pedido.Pedido;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.backend.backend.domain.pedido.PedidoRepository;
import com.backend.backend.domain.producto.Producto;
import com.backend.backend.domain.producto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    private Random random = new Random();

    @Override
    public Pedido createPedido(PedidoDTO pedidoDTO) {

        if (productoRepository.findById(pedidoDTO.idProducto()).isEmpty()) {
            throw  new RuntimeException("Producto: " + MessageApplication.NOTFOUND);
        }

        if (clienteRepository.findById(pedidoDTO.idCliente()).isEmpty()) {
            throw  new RuntimeException("Cliente: " + MessageApplication.NOTFOUND);
        }

        if (bodegaRepository.findById(pedidoDTO.idBodega()).isEmpty()) {
            throw  new RuntimeException("Bodega: " + MessageApplication.NOTFOUND);
        }

        Producto producto= productoRepository.getReferenceById(pedidoDTO.idProducto());
        Cliente cliente = clienteRepository.getReferenceById(pedidoDTO.idCliente());
        Bodega bodega= bodegaRepository.getReferenceById(pedidoDTO.idBodega());

        Pedido savePedido = PedidoMapper.toPedido(pedidoDTO);

        savePedido.setPrecioFinal(caclulaPrecioFinal(savePedido.getCantidadProducto(),bodega.getTipoBodega(), savePedido.getPrecioDeEnvio()));
        savePedido.setIdetentificacionVehiculo(generarPlacaVehiculo(bodega.getTipoBodega()));
        savePedido.setFechaDeCreacion(LocalDate.now());
        savePedido.setFechaDeEntrega(caculaFechaDeEntrega(savePedido.getFechaDeCreacion()));
        savePedido.setNumeroDeGuia(calculaNumeroDeGuia(bodega.getTipoBodega()));
        savePedido.setProducto(producto);
        savePedido.setCliente(cliente);
        savePedido.setBodega(bodega);

        return pedidoRepository.save(savePedido);
    }

    @Override
    public Pedido getPedido(Long id) {
        return pedidoRepository.getReferenceById(id);
    }


    private String generarPlacaVehiculo(TipoBodega tipoBodega) {
        Integer cantidadLDigitos= tipoBodega== tipoBodega.TERRESTRE? 3 :4;
        String letras = generaLetraAleatoria(3);
        String digitos = generaDigitoAleatorio(cantidadLDigitos);
        String letraFinal = tipoBodega == tipoBodega.TERRESTRE ? "" : generaLetraAleatoria(1);
        return letras + digitos + letraFinal;
    }

    private String generaLetraAleatoria(Integer count) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char letraAleatoria = alfabeto.charAt(random.nextInt(alfabeto.length()));
            resultado.append(letraAleatoria);
        }
        return resultado.toString();
    }

    private String generaDigitoAleatorio(Integer count) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int digitoAleatorio = random.nextInt(10);
            resultado.append(digitoAleatorio);
        }
        return resultado.toString();
    }

    private BigDecimal caclulaPrecioFinal(BigInteger cantidad,TipoBodega tipoBodega, BigDecimal precio){
        if (cantidad.compareTo(BigInteger.valueOf(10))>0){
            if (tipoBodega == TipoBodega.TERRESTRE){
               return precio.multiply(BigDecimal.valueOf(1 - 0.05));
            }
            if (tipoBodega== TipoBodega.MARITIMA){
                return precio.multiply(BigDecimal.valueOf(1 - 0.03));
            }
        }
        return precio;
    }

    private String calculaNumeroDeGuia(TipoBodega tipoBodega){

        int secuencia= 10000+ random.nextInt(90000);
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM");
        String secuenciaFinal = tipoBodega.name().substring(0,1) + localDate.format(formatter) + secuencia;

        while (Boolean.TRUE.equals(pedidoRepository.existsByNumeroDeGuia(secuenciaFinal))){
            secuencia= 10000+ random.nextInt(90000);
            secuenciaFinal = tipoBodega.name().substring(0,1) + localDate.format(formatter) + secuencia;
        }
        return secuenciaFinal;
    }

    private LocalDate caculaFechaDeEntrega(LocalDate fechaInicial){
        return fechaInicial.plusDays(random.nextInt(10));
    }




}
