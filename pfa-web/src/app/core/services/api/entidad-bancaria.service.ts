import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { EntidadBancaria } from '../../models/entidad-bancaria';

@Injectable({ providedIn: 'root' })
export class EntidadBancariaService {

    constructor(private apiBase: ApiBaseService) {

    }

    async getAll(): Promise<EntidadBancaria[]> {
        return await this.apiBase.get<EntidadBancaria[]>('entidad/obtenerEntidades');
    }

    async getByCode(id: string): Promise<EntidadBancaria> {
        return await this.apiBase.get<EntidadBancaria>(`entidad/obtenerEntidadPorCodigo/${id}`);
    }

    async create(entidadBancaria: EntidadBancaria) {
        await this.apiBase.post('entidad/crear', entidadBancaria);
    }

    async update(entidadBancaria: EntidadBancaria) {
        return await this.apiBase.put('entidad/editar', entidadBancaria);
    }

    async delete(id: number) {
        return await this.apiBase.delete(`entidad/eliminar/${id}`);
    }
}