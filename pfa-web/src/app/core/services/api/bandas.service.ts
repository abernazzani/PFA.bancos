import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Banda } from '../../models/banda';

@Injectable({ providedIn: 'root' })
export class BandasService {

    constructor(private apiService: ApiBaseService) {

    }

    async getAll(): Promise<Banda[]> {
        let bandas = await this.apiService.get<Banda[]>("banda/obtenerBandas");
        return bandas.map(x => Banda.parse(x));
    }

    async getPorCodigo(codigo: string): Promise<Banda> {
        let banda = await this.apiService.get(`/banda/porCodigo/${codigo}`);
        return Banda.parse(banda);
    }

    async create(banda: Banda) {
        await this.apiService.post("/banda/crear", banda);
    }

    async update(banda: Banda) {
        await this.apiService.put("/banda/actualizar", banda);
    }

    async delete(codigo: string) {
        await this.apiService.delete(`/banda/eliminar/${codigo}`);
    }
}