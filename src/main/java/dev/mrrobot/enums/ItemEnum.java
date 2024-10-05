package dev.mrrobot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemEnum {

    MINERAL_CALIZA(1, "mineral caliza"),
    MINERAL_HIERRO(2, "mineral hierro"),
    MINERAL_COBRE(3, "mineral cobre"),
    MINERAL_CATERIO(4, "mineral caterio"),
    MINERAL_CARBON(5, "mineral carbon"),
    MINERAL_CUARZO(6, "mineral cuarzo"),
    MINERAL_AZUFRE(7, "mineral azufre"),
    MINERAL_BAUXITA(8, "mineral bauxita"),
    MINERAL_MAR(9, "mineral mar"),
    MINERAL_URANIO(10, "mineral uranio"),
    LGT_HIERRO(11, "lgt hierro"),
    LGT_COBRE(12, "lgt cobre"),
    LGT_CATERIO(13, "lgt caterio"),
    LGT_ACERO(14, "lgt acero"),
    LGT_ALUMINIO(15, "lgt aluminio"),
    LGT_FICSITA(16, "lgt ficsita"),
    HORMIGON(17, "hormigon"),
    CRISTAL_CUARZO(18, "cristal cuarzo"),
    SILICIE(19, "silicie"),
    COBRE_EN_POLVO(20, "cobre en polvo"),
    RESINA_POLIMERO(21, "resina polimero"),
    COQUE_PETROLEO(22, "coque petroleo"),
    CHATARRA_ALUMINIO(23, "chatarra aluminio"),
    BARRA_HIERRO(24, "barra hierro"),
    TORNILLO(25, "tornillo"),
    PLANCHA_HIERRO(26, "plancha hierro"),
    PLANCHA_HIERRO_REFORZADO(27, "plancha hierro reforzado"),
    LAMINA_COBRE(28, "lamina cobre"),
    LAMINA_ALUMINIO(29, "lamina aluminio"),
    CARCASA_ALUMINIO(30, "carcasa aluminio"),
    TUBERIA_ACERO(31, "tuberia acero"),
    VIGA_ACERO(32, "viga acero"),
    VIGA_INDUSTRIAL(33, "viga industrial"),
    ARMAZON_MODULAR(34, "armazon modular"),
    ARMAZON_MODULAR_PESADO(35, "armazon modular pesado"),
    ARMAZON_MODULAR_FUSIONADO(36, "armazon modular fusionado"),
    TRIGONO_FICSITA(37, "trigono ficsita"),
    TEJIDO(38, "tejido"),
    PLASTICO(39, "plastico"),
    GOMA(40, "goma"),
    ROTOR(41, "rotor"),
    ESTATOR(42, "estator"),
    BATERIA(43, "bateria"),
    MOTOR(44, "motor"),
    DISIPADOR_CALOR(45, "disipador calor"),
    SISTEMA_REFRIGERACION(46, "sistema refrigeracion"),
    MOTOR_TURBO(47, "motor turbo"),
    ALAMBRE(48, "alambre"),
    CABLE(49, "cable"),
    TURBOALAMBRE(50, "turboalambre"),
    CIRCUITO_IMPRESO(51, "circuito impreso"),
    LIMITADOR_IA(52, "limitador ia"),
    CONECTOR_ALTA_VELOCIDAD(53, "conector alta velocidad"),
    MAR_REANIMADA(54, "mar reanimada"),
    FLUCTUADOR_MAR(55, "fluctuador mar"),
    ORDENADOR(56, "ordenador"),
    SUPERCOMPUTADORA(57, "supercomputadora"),
    ORDENADOR_CUANTICO(58, "ordenador cuantico"),
    UNIDAD_DE_CONTROL_RADIO(59, "unidad de control radio"),
    OSCILADOR_CRISTAL(60, "oscilador cristal"),
    OSCILADOR_SUPERPOSICION(61, "oscilador superposicion"),
    DIAMANTES(62, "diamantes"),
    CRONOCRISTALES(63, "cronocristales"),
    CRISTAL_MAT_OSCURA(64, "cristal mat oscura"),
    CELULA_DE_SINGULARIDAD(65, "celula de singularidad"),
    PROCESADOR_NEUROCUANTICO(66, "procesador neurocuantico"),
    MATRIZ_ENERGIA_ALIELIGENA(67, "matriz energia alieligena"),
    RECIPIENTE_VACIO(68, "recipiente vacio"),
    BOMBONA_FLUIDOS_VACIA(69, "bombona fluidos vacia"),
    CUBO_CONVERSOR_PRESIONES(70, "cubo conversor presiones"),
    AGUA_ENVASADO(71, "agua envasado"),
    SOLUCION_DE_ALUMINA_ENVASADA(72, "solucion de alumina envasada"),
    ACIDO_SULFURICO_ENVASADO(73, "acido sulfurico envasado"),
    GAS_NITROGENO_ENVASADO(74, "gas nitrogeno envasado"),
    TURBOCOMBUSTIBLE_ENVASADO(75, "turbocombustible envasado"),
    COMBUSTIBLE_COHETE_ENVASADO(76, "combustible cohete envasado"),
    POLVORA(77, "polvora"),
    POLVORA_SIN_HUMO(78, "polvora sin humo"),
    FILTRO_GAS(79, "filtro gas"),
    CARTUCHO_COLOR(80, "cartucho color"),
    FILTRO_YODO(81, "filtro yodo"),
    VARILLA_HIERRO(82, "varilla hierro"),
    VARILLA_EXPLOSIVA(83, "varilla explosiva"),
    MUNICION_RIFLE(84, "municion rifle"),
    MUNICION_RIFLE_BUSCADOR(85, "municion rifle buscador"),
    MUNICION_RIFLE_TURBO(86, "municion rifle turbo"),
    NOBELISCO(87, "nobelisco"),
    NOBELISCO_FRAGMENTACION(88, "nobelisco fragmentacion"),
    RESIDUO_PETROLEO(89, "residuo petroleo"),
    UNDEFINED(90, "-");

    private final int id;
    private final String name;

    public static ItemEnum getItem(int id) {

        for (ItemEnum i : ItemEnum.values()) {
            if (i.getId() == id) return i;
        }
        return UNDEFINED;
    }

    public static ItemEnum getItem(String name) {

        for (ItemEnum i : ItemEnum.values()) {
            if (i.getName().equals(name)) return i;
        }
        return UNDEFINED;
    }

}
