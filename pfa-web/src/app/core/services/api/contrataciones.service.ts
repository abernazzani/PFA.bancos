import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Contratacion } from '../../models/contratacion';
import { Sucursal } from '../../models/sucursal';
import { Vigilante } from '../../models/vigilante';

@Injectable({ providedIn: 'root' })
export class ContratacionesService {
    constructor(private apiBase: ApiBaseService) { }

    getAll() {
        return this.apiBase.get<Contratacion[]>('contrataciones');
    }

    async getPorCodigoSucursal(codigo: String) {
        return await this.apiBase.get<Contratacion>(`contrataciones/PorCodigoSucursal/${codigo}`);
    }

    async getPorPorFechaYCodVigilante(codigo: String, fecha: String) {
        //return await this.apiBase.get<Contratacion>(`contrataciones/getPorFechaYCodVigilante/codigo/${codigo}/fecha/${fecha}`);
        return await this.apiBase.get<Contratacion>(`contrataciones/getPorFechaYCodVigilante/${codigo}/${fecha}`);

    }



    async getPorCodigoVigilante(codigo: String): Promise<Contratacion> {
        // return await this.apiBase.get<Contratacion[]>(`contrataciones/PorCodigoVigilante/${codigo}`);
        let contrataciones = await this.getAll();
        return contrataciones.find(x => codigo == x.codigoVigilante);

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

    async delete(codigo: String, fecha: String) {
        console.log(codigo, fecha);
        //return await this.apiBase.delete(`contrataciones/codigo/${codigo}/fecha/${fecha}`);
        return await this.apiBase.delete(`contrataciones/${codigo}/${fecha}`);
    }


    // metodos para form-controls

    async traerSucursales() {
        return this.apiBase.get<Sucursal[]>('sucursal/traerTodas');
    }

    async traerVigilantes(): Promise<Vigilante[]> {
        return this.apiBase.get<Vigilante[]>("vigilante");
    }

    async traerVigilante(usuario: String): Promise<Vigilante> {
        //return this.apiBase.get<Vigilante>('sucursal/traerTodas');
        return this.apiBase.get(`vigilante/getPorUsuario/${usuario}`);
    }

}