# Étape de build
FROM node:16 as build-step
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Étape de production
FROM nginx:alpine
COPY --from=build-step  /dist/app-front /usr/share/nginx/html
EXPOSE 80

