import { Asalto } from './asalto';
import { Delincuente } from './delincuente';

export class Condena {

    delincuente: Delincuente;
    asalto: Asalto;
    codigoDelincuente: string;
    codigoAsalto: number;
    fechaDeInicio: Date;
    fechaFin: Date;
}
