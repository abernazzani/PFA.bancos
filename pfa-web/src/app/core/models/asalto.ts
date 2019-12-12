import { Delincuente } from './delincuente';

export class Asalto {
    id: number;
    fecha: Date;
    codigoSucursal: string;
    codigoJuez: string;
    delincuentes: string[];
}