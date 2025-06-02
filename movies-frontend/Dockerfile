FROM node:20-alpine AS build
WORKDIR /app
COPY . .

RUN npm install -g @angular/cli
RUN npm install
RUN ng build

FROM nginx:alpine

ENV API_URL http://localhost:8084/api

EXPOSE 80

COPY templates/ /etc/nginx/templates/
COPY --from=build /app/dist/movies-frontend/browser /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]