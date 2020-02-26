import { Component, OnInit, Input } from '@angular/core';
import { Usuario} from 'src/app/core/models/usuario';
import { UsuariosService } from 'src/app/core/services/api/usuarios.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';

@Component({
    selector: 'usuarios-edit',
    templateUrl: 'edit.component.html'
})

export class UsuariosEditComponent implements OnInit {
    loading: boolean;

    @Input()
    id: number;

    protected usuario: Usuario;

    constructor(private UsuariosService: UsuariosService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        await this.activatedRoute.params.subscribe(async params => {
            this.id = this.id || params["id"];
            if (this.id) {
                this.usuario = await this.UsuariosService.getById(this.id);
            } else {
                this.usuario = new Usuario();
            }
        });

    }

    async save() {
        debugger;
        if (this.id) {
            await this.UsuariosService.update(this.usuario);
        } else {
            await this.UsuariosService.create(this.usuario);
        }
        this.activeModal.close(ModalResult.Ok);
    }

    cancel() {
        if (this.ngbModalService.hasOpenModals()) {
            this.activeModal.close(ModalResult.Cancel);
        } else {
            this.location.back();
        }
    }
}