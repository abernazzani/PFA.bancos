import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Vigilante } from '../../models/vigilante';

@Injectable({ providedIn: 'root' })
export class VigilantesService {

    constructor(private apiService: ApiBaseService) {

    }

    async getAll(): Promise<Vigilante[]> {
        return this.apiService.get<Vigilante[]>("vigilante");
        //return vigilantes.map(x => Vigilante.parse(x));
    }

    async getPorCodigo(codigo: string): Promise<Vigilante> {
        return this.apiService.get(`vigilante/getPorCodigo/${codigo}`);
        
    }

    async create(vigilante: Vigilante) {
        await this.apiService.post("vigilante", vigilante);
    }

     async update(vigilante: Vigilante) {
         await this.apiService.put("vigilante", vigilante);
    }

    async delete(codigo: string) {
        await this.apiService.delete(`vigilante/${codigo}`);
    }
}