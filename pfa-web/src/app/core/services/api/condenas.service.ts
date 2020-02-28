import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Condena} from '../../models/condena';
import { Sucursal } from '../../models/sucursal';
import { Vigilante } from '../../models/vigilante';

@Injectable({ providedIn: 'root' })
export class CondenasService {
    constructor(private apiBase: ApiBaseService) { }

    getAll() {
        return this.apiBase.get<Condena[]>('condenas');
    }

    async getPorCodigoSucursal(codigo: String) {
        return await this.apiBase.get<Condena>(`condenas/PorCodigoSucursal/${codigo}`);
    }
    
    async  getPorDelincuenteyAsalto(codigoD: String, codigoA: number) {
        //return await this.apiBase.get<Contratacion>(`contrataciones/getPorFechaYCodVigilante/codigo/${codigo}/fecha/${fecha}`);
        return await this.apiBase.get<Condena>(`condenas/getPorDelincuenteyAsalto/${codigoD}/${codigoA}`);
    
    }
    


    // async getPorCodigoVigilante(codigo: String): Promise<Contratacion> {
    //    // return await this.apiBase.get<Contratacion[]>(`contrataciones/PorCodigoVigilante/${codigo}`);
    //     let contrataciones = await this.getAll();
    //     return contrataciones.find(x => codigo == x.codigoVigilante);
    
    // }

   

    async getPorFecha(fecha: Date) {
        return await this.apiBase.get<Condena[]>(`condenas/PorFecha/${fecha}`);
    }

    async create(condena: Condena) {
        return await this.apiBase.post(`condenas`, condena);
    }

    async update(condena: Condena) {
        console.log(condena);
        return await this.apiBase.put(`condena`, condena);
    }

    async delete(codigoDelincuente: String, codigoAsalto: number) {
        //console.log(codigo , fecha);
        //return await this.apiBase.delete(`contrataciones/codigo/${codigo}/fecha/${fecha}`);
        return await this.apiBase.delete(`condena/${codigoDelincuente}/${codigoAsalto}`);
    }


    // metodos para form-controls

    async traerSucursales() {
        return this.apiBase.get<Sucursal[]>('sucursal/traerTodas');
    }

    async traerVigilantes(): Promise<Vigilante[]> {
        return this.apiBase.get<Vigilante[]>("vigilante");
    }

    async traerVigilante(usuario : String): Promise<Vigilante> {
        //return this.apiBase.get<Vigilante>('sucursal/traerTodas');
        return this.apiBase.get(`vigilante/getPorUsuario/${usuario}`);
    }

}