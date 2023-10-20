import {
    ConnectionModel,
    ConnectionTagsApi,
    ConnectionsApi,
    UpdateConnectionTagsRequest,
} from '@/middleware/helios/connection';
import {useMutation} from '@tanstack/react-query';

type CreateConnectionMutationProps = {
    onSuccess?: (result: ConnectionModel, variables: ConnectionModel) => void;
    onError?: (error: Error, variables: ConnectionModel) => void;
};

export const useCreateConnectionMutation = (
    mutationProps?: CreateConnectionMutationProps
) =>
    useMutation<ConnectionModel, Error, ConnectionModel>({
        mutationFn: (connectionModel: ConnectionModel) => {
            return new ConnectionsApi().createConnection({
                connectionModel,
            });
        },
        onError: mutationProps?.onError,
        onSuccess: mutationProps?.onSuccess,
    });

type DeleteConnectionMutationProps = {
    onSuccess?: () => void;
    onError?: (error: Error, id: number) => void;
};

export const useDeleteConnectionMutation = (
    mutationProps?: DeleteConnectionMutationProps
) =>
    useMutation<void, Error, number>({
        mutationFn: (id: number) => {
            return new ConnectionsApi().deleteConnection({
                id,
            });
        },
        onError: mutationProps?.onError,
        onSuccess: mutationProps?.onSuccess,
    });

type UpdateConnectionMutationProps = {
    onSuccess?: (result: ConnectionModel, variables: ConnectionModel) => void;
    onError?: (error: Error, variables: ConnectionModel) => void;
};

export const useUpdateConnectionMutation = (
    mutationProps?: UpdateConnectionMutationProps
) =>
    useMutation<ConnectionModel, Error, ConnectionModel>({
        mutationFn: (connection: ConnectionModel) => {
            return new ConnectionsApi().updateConnection({
                connectionModel: connection,
                id: connection.id!,
            });
        },
        onError: mutationProps?.onError,
        onSuccess: mutationProps?.onSuccess,
    });

type UpdateConnectionTagsMutationProps = {
    onSuccess?: (result: void, variables: UpdateConnectionTagsRequest) => void;
    onError?: (error: object, variables: UpdateConnectionTagsRequest) => void;
};

export const useUpdateConnectionTagsMutation = (
    mutationProps?: UpdateConnectionTagsMutationProps
) =>
    useMutation<void, Error, UpdateConnectionTagsRequest>({
        mutationFn: (request: UpdateConnectionTagsRequest) => {
            return new ConnectionTagsApi().updateConnectionTags(request);
        },
        onError: mutationProps?.onError,
        onSuccess: mutationProps?.onSuccess,
    });
