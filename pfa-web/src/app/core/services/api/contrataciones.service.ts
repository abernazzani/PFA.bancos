import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Contratacion} from '../../models/contratacion';

@Injectable({ providedIn: 'root' })
export class ContratacionesService {
    constructor(private apiBase: ApiBaseService) { }

    getAll() {
        return this.apiBase.get<Contratacion[]>('contrataciones');
    }

    async getPorCodigoSucursal(codigo: string) {
        return await this.apiBase.get<Contratacion>(`contrataciones/PorCodigoSucursal${codigo}`);
    }

    async getPorCodigoVigilante(codigo: String) {
        return await this.apiBase.get<Contratacion[]>(`contrataciones/PorCodigoVigilante/${codigo}`);
    }

    async getPorFecha(fecha: Date) {
        return await this.apiBase.get<Contratacion[]>(`contrataciones/PorFecha/${fecha}`);
    }

    async create(contratacion: Contratacion) {
        return await this.apiBase.post(`contrataciones`, contratacion);
    }

    async update(contratacion: Contratacion) {
        console.log(contratacion);
        return await this.apiBase.put(`contrataciones`, contratacion);
    }

    async delete(contratacion: Contratacion) {
        console.log(contratacion);
        //return await this.apiBase.delete(`contrataciones`, contratacion);
    }


}