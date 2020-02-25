import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Delincuente } from '../../models/delincuente';
import { Sucursal } from '../../models/sucursal';

@Injectable({ providedIn: 'root' })
export class SucursalesService {
    constructor(private apiBase: ApiBaseService) { }

    getAll() {
        return this.apiBase.get<Sucursal[]>('sucursal/traerTodas');
    }

    async getByCode(codigo: string) {
        return await this.apiBase.get<Sucursal>(`sucursal/obtener/${codigo}`);
    }

    async create(sucursal: Sucursal) {
        return await this.apiBase.post(`sucursal/crear`, sucursal);
    }

    async update(sucursal: Sucursal) {
        console.log(sucursal);
        return await this.apiBase.put(`sucursal`, sucursal);
    }

    async delete(codigo: string) {
        return await this.apiBase.delete(`sucursal/${codigo}`);
    }
}